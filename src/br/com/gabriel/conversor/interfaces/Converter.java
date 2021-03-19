package br.com.gabriel.conversor.interfaces;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Converter<VO, DTO> {

	final String GET = "get";
	final String SET = "set";

	default DTO from(final VO vo) {

		Class<?> dtoClass = this.getClass();

		Stream<Method> streamMetodosClasseVoList = carregarMetodosClasseVO(vo);

		Stream<Method> streamMetodosDTO = carregarMetodosClasseDTO(dtoClass);

		List<Method> listaDosMetodosSetDoDTO = streamMetodosDTO.filter(m -> m.getName().startsWith(Converter.SET))
				.collect(Collectors.toList());

		Stream<Method> streamComApenasMetodosGetFiltradosDaClasseVO = streamMetodosClasseVoList
				.filter(m -> m.getName().startsWith(Converter.GET));

		List<String> listaComApenasNomesDosMetodosDaClassDTOSemPrefixoSet = obterListaComApenasNomesDosMetodosDaClassDTOSemPrefixoSet(
				listaDosMetodosSetDoDTO);

		List<Method> streamComMetodosGetDoVO = streamComApenasMetodosGetFiltradosDaClasseVO
				.filter(m -> ehUmMetodoGetValido(listaComApenasNomesDosMetodosDaClassDTOSemPrefixoSet, m.getName()))
				.collect(Collectors.toList());

		return createDTO(vo, dtoClass, listaDosMetodosSetDoDTO, streamComMetodosGetDoVO);

	}

	private List<String> obterListaComApenasNomesDosMetodosDaClassDTOSemPrefixoSet(
			List<Method> listaDosMetodosSetDoDTO) {
		return listaDosMetodosSetDoDTO.stream().map(m -> obterNomeSemPrefixo(m.getName(), TipoNome.SET))
				.collect(Collectors.toList());
	}

	private boolean ehUmMetodoGetValido(List<String> listaComApenasNomesDosMetodosDaClassDTOSemPrefixoSet,
			String nomeMetodo) {
		return listaComApenasNomesDosMetodosDaClassDTOSemPrefixoSet
				.contains(obterNomeSemPrefixo(nomeMetodo, TipoNome.GET));
	}

	private Stream<Method> carregarMetodosClasseVO(final VO vo) {
		Class<?> voClass = vo.getClass();
		Method[] metodosClasseVO = voClass.getMethods();
		Stream<Method> streamMetodosClasseVoList = List.of(metodosClasseVO).stream();
		return streamMetodosClasseVoList;
	}

	private Stream<Method> carregarMetodosClasseDTO(Class<?> c) {
		Method[] metodosCurrentClass = c.getMethods();
		return List.of(metodosCurrentClass).stream();
	}

	@SuppressWarnings("unchecked")
	private DTO createDTO(final VO vo, Class<?> dtoClass, List<Method> streamComApenasMetodosSetDaClasseDTO,
			List<Method> streamComMetodosGetDoVO) {
		DTO dto = null;

		try {
			Constructor<? extends Object> constructorDTO = dtoClass.getConstructor();
			final Object instanciaDTO = constructorDTO.newInstance();

			invocaMetodosSetDoDtoComOsRetornosDosMetodosVoSimilares(vo, streamComApenasMetodosSetDaClasseDTO,
					streamComMetodosGetDoVO, instanciaDTO);

			dto = (DTO) instanciaDTO;

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return dto;
	}

	private void invocaMetodosSetDoDtoComOsRetornosDosMetodosVoSimilares(final VO vo,
			List<Method> streamComApenasMetodosSetDaClasseDTO, List<Method> streamComApenasMetodosGetDaClasseVO,
			final Object instanciaDTO) {

		Comparator<? super Method> comparator = (current, next) -> current.getName().compareTo(next.getName());
		streamComApenasMetodosGetDaClasseVO.sort(comparator);
		streamComApenasMetodosSetDaClasseDTO.sort(comparator);

		streamComApenasMetodosGetDaClasseVO.forEach(m -> {
			streamComApenasMetodosSetDaClasseDTO.forEach(m2 -> {

				String nomeMetodoVO = obterNomeSemPrefixo(m.getName(), TipoNome.GET);
				String nomeMetodoDTO = obterNomeSemPrefixo(m2.getName(), TipoNome.SET);

				if (nomeMetodoDTO.equals(nomeMetodoVO)) {
					try {
						m2.invoke(instanciaDTO, m.invoke(vo));
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						throw new RuntimeException(e);
					}
				}
			});
		});
	}

	private String obterNomeSemPrefixo(String nome, TipoNome tipoNome) {
		return tipoNome.remover(nome);
	}

}






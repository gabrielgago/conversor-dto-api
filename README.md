# conversor-dto-api
Api desenvolvida para facilitar o trabalho do desenvolvedor em converter um objeto modelo em um dto.

Para diminuir o famoso código repetitivo.

E muito facil usar a API.

Apenas deve implementar a interface Converter<VO,DTO> do pacote br.com.gabriel.conversor.interfaces em sua classe DTO.

Parâmetro VO, indica o tipo do objeto de domínio, ex:. CategoriaVO | Categoria...
Parâmetro DTO, indica o tipo do objeto DTO a ser convertido, ex: CategoriaDTO...

Ao instanciar o objeto DTO é só chamar o método "from" que vem herdado da interface Converter e pronto! Seu DTO estará pronto para ser usado !

Lembrando que a API utiliza o padrão JavaBean então não se esqueça de adicionar os GETTER's e SETTER's direitinho !

Podem contribuir o quanto quiser !

Observações:
Esta API não se encontra em nenhum repositório visto que acabou de ser desenvolvida e ainda esta em fase de teste,
para utiliza-la apenas gere um JAR a partir do projeto clonado com o nome "conversor-dto-api.jar" em alguma pasta do seu computador e depois importe no seu projeto.
Ou caso utilize maven, criar uma pasta dentro de SRC/MAIN/RESOURCES com o nome que desejar, eu costumo usar o nome "artefatos", adicionar o jar nesta pasta e em seu arquivo pom
adicionar a seguinte dependencia.

```
<dependency>
			<groupId>br.com.gabriel.conversor</groupId>
			<artifactId>conversor-dto</artifactId>
			<version>1.0</version>
			<scope>system</scope>
			<systemPath>${project.basedir}/src/main/resources/artefatos/conversor-dto-api.jar</systemPath>
	</dependency>
```

Até mais e espero ter ajudado !

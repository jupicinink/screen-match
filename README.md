# Screen Match — Resumo de ferramentas e tecnologias

Projeto de estudo (curso Alura) para modelagem simples de filmes/séries, cálculo de tempo e uso da API OMDb.

Principais tecnologias
- Java (JDK 11+)
- Biblioteca Gson para parsing JSON: [lib/gson-2.10.1.jar](lib/gson-2.10.1.jar), [libs/gson-2.8.9.jar](libs/gson-2.8.9.jar)
- Ferramenta de execução: javac / java
- IDE/Editor: Visual Studio Code (configuração em [.vscode/settings.json](.vscode/settings.json))
- API externa: OMDb (chave em [key_api.txt](key_api.txt), ignorado em git via [.gitignore](.gitignore))

Arquivos e classes principais
- Entrada / exemplos: [filmes.txt](filmes.txt)
- Código-fonte: [src](src)
  - Entradas/gestão: [src/Main/Main.java](src/Main/Main.java), [src/Main/MainWithSearch.java](src/Main/MainWithSearch.java)
  - Modelos: [`src.models.Title`](src/models/Title.java), [`src.models.TitleOmdb`](src/models/TitleOmdb.java), [`src.models.Movie`](src/models/Movie.java), [`src.models.Serie`](src/models/Serie.java), [`src.models.Episode`](src/models/Episode.java), [`src.models.ErroDeConversaoDeAnoException`](src/models/ErroDeConversaoDeAnoException.java)
  - Cálculos / regras: [`src.calculos.TimeCalculator`](src/calculos/TimeCalculator.java), [`src.calculos.FiltroRecomendacao`](src/calculos/FiltroRecomendacao.java), [`src.calculos.Classificavel`](src/calculos/Classificavel.java)

Como compilar
```sh
javac -cp "libs/gson-2.8.9.jar:lib/gson-2.10.1.jar" -d out $(find src -name "*.java")
```

Como executar
- Main local:
```sh
java -cp "out:libs/gson-2.8.9.jar" src.Main.Main
```
- Main com busca OMDb (forneça sua API key em [key_api.txt](key_api.txt) ou modifique o código com cuidado):
```sh
java -cp "out:lib/gson-2.10.1.jar" src.Main.MainWithSearch
```

Observações rápidas
- A conversão do JSON OMDb é feita com [`src.models.TitleOmdb`](src/models/TitleOmdb.java) e mapeada para [`src.models.Title`](src/models/Title.java).
- A chave da OMDb não deve ser versionada — está listada em [.gitignore](.gitignore).
- Para testes rápidos, veja [filmes.txt](filmes.txt).

Contribuições e alterações são bem-vindas para fins de estudo

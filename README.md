# Projeto-TCC-Fundatec
Front End do projeto "Solo Craft" desenvolvido para o TCCII;

## Para que serve?

Está aplicação é um gerenciador de serviços, para trabalhadores autonomos que realizam serviços fora de casa.
Facilitando a organização de seus serviços e clientes, lucros e despesas.

---

## Funcionalidades:

- Cadastro de conta
- Login
- Cadastro de serviços
- Consulta dos serviços cadastrados
- Deletar serviços em andamento
- Finalizar serviços em andamento
- Adicinar custos no serviço em andamento
- Cadastro de clientes
- Consulta de clientes
- Gerar relatórios
- Consultar relatórios

---

## Como Utilizar? 

Versões android/kotlin utilizada:

```
plugins {
    id 'com.android.application' version '7.4.2' apply false
    id 'com.android.library' version '7.4.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.7.21' apply false
}
```

Atualmente o projeto é executado em local host, ou pode ser gerado uma apk para testar.

#### como gerar apk:
No android studio vá até Build -> Build Bundle(s) / APK(s) -> Build APK(s)

### Rodando o projeto em LocalHost:

#### Observações:
Este projeto é altamente dependente do funcionamento da api: http://44.198.225.29:8080/solocraft/
Se a mesma não estiver funcionando ou estiver fora do ar, suba localmente e altere as configurações de conexão, link do projeto: https://github.com/mairyeduardo/Projeto-TCC-Fundatec-BackEnd 

#### Necessario:

- Possuir o Android Studio
- Criar um Celular Virtual ou conectar um dispositivo via usb para rodar o projeto

#### Instalar dependencias Gradle:

Faça a Build do projeto utilizando o Gradle, as dependencias do projeto devem estar mantidas no arquivo `app\build.gradle`.

#### Rodando Via IDE:

Para rodar o projeto Execute o `app` via android studio.

---

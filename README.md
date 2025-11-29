
-----

## PT-BR

# 🔗 CreateUrlLambda - Encurtador de URL Serverless com AWS Lambda e Java 21

[](https://www.google.com/search?q=https://www.java.com/pt-br/)
[](https://aws.amazon.com/pt/lambda/)
[](https://maven.apache.org/)

-----

## 💡 Sobre o Projeto

O **CreateUrlLambda** é um projeto de encurtador de URL (URL Shortener) desenvolvido para ser executado em uma arquitetura **Serverless** utilizando **AWS Lambda**.

O objetivo principal é oferecer uma solução escalável e de baixo custo para a criação e gestão de links curtos, aproveitando o poder e a performance da versão **Java 21** e a infraestrutura robusta da AWS.

Diagrama da Solução: https://whimsical.com/url-shortener-kipper-workshop-X2doHfW6SxQZnzRFSbhaTR

-----

## ✨ Funcionalidades

  * **Encurtamento Eficiente:** Criação rápida de um identificador único para cada URL longa.
  * **Arquitetura Serverless:** Totalmente hospedado no AWS Lambda, garantindo alta disponibilidade e escalabilidade automática sem a necessidade de gerenciar servidores.
  * **Desenvolvimento Moderno:** Utilização de recursos modernos do **Java 21** para um código conciso e de alto desempenho.

-----

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias e dependências, conforme o arquivo `pom.xml`:

| Categoria | Tecnologia | Uso |
| :--- | :--- | :--- |
| **Linguagem** | **Java 21** | Linguagem de desenvolvimento principal. |
| **Infraestrutura** | **AWS Lambda** | Ambiente de execução Serverless. |
| **Build** | **Apache Maven** | Gerenciamento de dependências e processo de build. |
| **Core AWS** | `aws-lambda-java-core` | Interface e classes base para o *handler* do Lambda. |
| **Logging** | `aws-lambda-java-log4j2` | Gerenciamento e configuração de logs na AWS. |
| **Boilerplate** | **Lombok** | Redução de código boilerplate (getters, setters, construtores). |
| **JSON** | `jackson-databind` | Serialização e desserialização de objetos Java para JSON (comunicação com a API Gateway/Payloads). |
| **Empacotamento** | `maven-shade-plugin` | Criação do **Uber JAR** (JAR com todas as dependências), essencial para o deploy no AWS Lambda. |

-----

## 🚀 Como Executar

### Pré-requisitos

Para buildar e executar o projeto localmente, você precisará ter instalado:

  * **JDK 21** ou superior
  * **Apache Maven**

### Instalação e Build

1.  Clone o repositório:

    ```bash
    git clone https://github.com/brunobd7/create-url-lambda.git
    cd create-url-lambda
    ```

2.  Execute o comando do Maven para compilar, testar e criar o *Uber JAR* (Fat JAR) que será usado no deploy:

    ```bash
    mvn clean package
    ```

    O artefato gerado estará em `target/CreateUrlLambda-1.0-SNAPSHOT.jar` (ou similar), pronto para ser enviado ao AWS Lambda.

-----

## ⚙️ Implantação (Deployment)

Para implantar este projeto na AWS Lambda, siga os passos principais:

1.  **Crie a função Lambda** no console da AWS.
2.  Selecione **Java 21** como o *Runtime*.
3.  Faça o **Upload do JAR** gerado pelo `maven clean package`.
4.  Configure o **Handler** da função Lambda com a classe e método corretos (Exemplo: `com.dantas.createUrlShortener.Handler::handleRequest`).
5.  Configure os recursos de infraestrutura necessários (e.g., **DynamoDB** para armazenar as URLs, caso ainda não esteja no código).
6.  Configure um **API Gateway** para expor a função Lambda via HTTP e permitir a criação de URLs curtas.

-----

## 📧 Contato

Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato:

**[Bruno Dantas](https://www.google.com/search?q=https://github.com/brunobd7)**

-----

-----

## EN  

# 🔗 CreateUrlLambda - Serverless URL Shortener with AWS Lambda and Java 21

[](https://www.java.com/)
[](https://aws.amazon.com/lambda/)
[](https://maven.apache.org/)

-----

## 💡 About the Project

**CreateUrlLambda** is a URL Shortener project developed to run in a **Serverless** architecture using **AWS Lambda**.

The main goal is to offer a scalable and low-cost solution for creating and managing short links, leveraging the power and performance of **Java 21** and AWS's robust infrastructure.

-----

## ✨ Features

  * **Efficient Shortening:** Quick creation of a unique identifier for each long URL.
  * **Serverless Architecture:** Fully hosted on AWS Lambda, ensuring high availability and automatic scalability without the need to manage servers.
  * **Modern Development:** Utilization of modern **Java 21** features for concise and high-performance code.

-----

## 🛠️ Technologies Used

This project was built using the following technologies and dependencies, as per the `pom.xml` file:

| Category | Technology | Usage |
| :--- | :--- | :--- |
| **Language** | **Java 21** | Main development language. |
| **Infrastructure** | **AWS Lambda** | Serverless execution environment. |
| **Build** | **Apache Maven** | Dependency management and build process. |
| **Core AWS** | `aws-lambda-java-core` | Interface and base classes for the Lambda *handler*. |
| **Logging** | `aws-lambda-java-log4j2` | Management and configuration of logs on AWS. |
| **Boilerplate** | **Lombok** | Reduction of boilerplate code (getters, setters, constructors). |
| **JSON** | `jackson-databind` | Serialization and deserialization of Java objects to JSON (communication with API Gateway/Payloads). |
| **Packaging** | `maven-shade-plugin` | Creation of the **Uber JAR** (JAR with all dependencies), essential for AWS Lambda deployment. |

-----

## 🚀 Getting Started

### Prerequisites

To build and run the project locally, you will need to have installed:

  * **JDK 21** or later
  * **Apache Maven**

### Installation and Build

1.  Clone the repository:

    ```bash
    git clone https://github.com/brunobd7/create-url-lambda.git
    cd create-url-lambda
    ```

2.  Run the Maven command to compile, test, and create the *Uber JAR* (Fat JAR) that will be used for deployment:

    ```bash
    mvn clean package
    ```

    The generated artifact will be located in `target/CreateUrlLambda-1.0-SNAPSHOT.jar` (or similar), ready to be uploaded to AWS Lambda.

-----

## ⚙️ Deployment

To deploy this project to AWS Lambda, follow the main steps:

1.  **Create the Lambda function** in the AWS console.
2.  Select **Java 21** as the *Runtime*.
3.  **Upload the JAR** generated by `maven clean package`.
4.  Configure the Lambda function **Handler** with the correct class and method (Example: `com.dantas.createUrlShortener.Handler::handleRequest`).
5.  Configure the necessary infrastructure resources (e.g., **DynamoDB** to store the URLs, if not already in the code).
6.  Set up an **API Gateway** to expose the Lambda function via HTTP and allow the creation of short URLs.

-----

## 📧 Contact

If you have any questions or suggestions, feel free to reach out:

**[Bruno Dantas](https://www.google.com/search?q=https://github.com/brunobd7)**

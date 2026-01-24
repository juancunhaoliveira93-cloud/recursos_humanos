🏢 Sistema de Recursos Humanos
Aplicação console desenvolvida em Java para auxiliar o setor de RH no gerenciamento de funcionários e departamentos. O projeto foca em operações essenciais (CRUD) e geração de relatórios simples.

🚀 Funcionalidades
Gestão de Funcionários: Cadastro, consulta, atualização e remoção.

Departamentos: Organização de colaboradores por setor.

Persistência de Dados: Armazenamento de informações em arquivos .txt.

Relatórios: Geração automática de ficheiros com os dados dos colaboradores cadastrados.

🛠 Tecnologias Utilizadas
Linguagem: Java (JDK 17)

IDE: Eclipse / VS Code

Armazenamento: Arquivos de texto (.txt)

Versionamento: Git & GitHub

📂 Estrutura do Projeto
src/: Contém o código-fonte da aplicação (Classes de entidade, lógica de negócio e interface via console).

Departamento.txt: Ficheiro utilizado para armazenar os dados dos departamentos.

.gitignore: Configuração para evitar o envio de ficheiros desnecessários para o repositório.

🏁 Como Executar o Projeto
Pré-requisitos: Ter o Java JDK 17 ou superior instalado.

Clonar o Repositório:

Bash
git clone https://github.com/juancunhaoliveira93-cloud/recursos_humanos.git
Compilar e Executar:

Abre o projeto na tua IDE de preferência.

Localiza a classe principal (com o método main).

Executa a classe para iniciar a interface no terminal.

📄 Exemplo de Uso
Ao iniciar o sistema, o utilizador pode navegar por menus numéricos para:

Cadastrar um novo colaborador informando nome, cargo e salário.

Listar todos os colaboradores guardados no ficheiro txt.

Gerar um relatório consolidado.
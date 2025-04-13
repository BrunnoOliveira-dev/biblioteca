document.addEventListener("DOMContentLoaded", function () {
    // Função para buscar livros da API
    fetch('http://localhost:8080/livros/8') // Substitua com a URL da sua API
        .then(response => response.json())
        .then(livro => {
            const livrosLista = document.getElementById("livros-lista");

            // Criando o card para cada livro
            const livroDiv = document.createElement("div");
            livroDiv.classList.add("livro");

            document.getElementById("titulo").innerHTML = livro.titulo;
            document.getElementById("autor").innerHTML = livro.autor;
            document.getElementById("editora").innerHTML = livro.editora;
            document.getElementById("ano").innerHTML = livro.data_publicacao;
            document.getElementById("isbn").innerHTML = livro.isbn;
            document.getElementById("descricao").innerHTML = livro.descricao;
            document.getElementById("capa").src = livro.imagem;


            livrosLista.appendChild(livroDiv);
        })
        .catch(error => {
            console.error("Erro ao carregar os livros:", error);
        });
});

// Event listeners
document
	.getElementById("formCadastro")
	.addEventListener("submit", async function (event) {
		event.preventDefault();

		const ISBN = document.getElementById("ISBN").value;
		const ISBN_limpo = limparISBN(ISBN);
		const data = await pegarDadosPeloISBN(ISBN_limpo);

		mostrarDados(data);
		mostrar_inputs();
	});

document
	.getElementById("confirmarCadastro")
	.addEventListener("click", function (event) {
		event.preventDefault();

		if (!validarCampos()) {
			alert("Por favor, preencha todos os campos obrigatórios.");
			return;
		}

		const livro = {
			isbn: document.getElementById("ISBN_input").value,
			titulo: document.getElementById("titulo").value,
			autor: document.getElementById("autor").value,
			editora: document.getElementById("editora").value,
			data_publicacao: document.getElementById("ano").value,
			descricao: document.getElementById("descricao").value,
			dataAquisicao: document.getElementById("data_aquisicao").value,
			imagem: document.getElementById("link_capa").value,
		};

		if (livro.exemplares <= 0) {
			alert("O número de exemplares deve ser maior que zero.");
			return;
		}

		enviarDadosParaBanco(livro);

		for (let i = 1; i <= livro.exemplares; i++) {
			exemplares(livro.isbn, livro.exemplares, i);
		}
	});

document
	.getElementById("link_capa")
	.addEventListener("input", function (event) {
		const imagemLink = event.target.value;
		document.getElementById("capa").src = imagemLink;
	});

// Funções de utilidade
function limparISBN(ISBN) {
	let newISBN = "";
	for (let i of ISBN) {
		if (i >= "0" && i <= "9") {
			newISBN += i;
		}
	}
	return newISBN;
}

function validarCampos() {
	const campos = [
		"ISBN_input",
		"titulo",
		"autor",
		"editora",
		"ano",
		"descricao",
		"exemplares",
		"data_aquisicao",
	];

	for (let campo of campos) {
		const valor = document.getElementById(campo).value;
		if (!valor || valor.trim() === "") {
			return false;
		}
	}
	return true;
}

function mostrar_inputs() {
	var div = document.getElementById("resposta");
	if (div.style.display == "none") {
		div.style.display = "flex";
	}
}

function toggleInfoText() {
	const infoText = document.getElementById("infoText");
	if (infoText.style.display === "none" || infoText.style.display === "") {
		infoText.style.display = "block";
	} else {
		infoText.style.display = "none";
	}
}

// Funções de manipulação de dados
async function pegarDadosPeloISBN(ISBN) {
	try {
		const response = await fetch(
			`https://www.googleapis.com/books/v1/volumes?q=isbn:${ISBN}`,
			{
				method: "GET",
				headers: {
					"Content-Type": "application/json",
				},
			}
		);

		const data = await response.json();

		if (data.totalItems === 0) {
			alert("Nenhum livro encontrado com esse ISBN.");
			return null;
		}

		return data;
	} catch (err) {
		console.log("Erro ao pegar dados pelo ISBN");
	}
}

function mostrarDados(dados) {
	console.log(dados);

	try {
		document.getElementById("capa").src =
			dados.items[0].volumeInfo.imageLinks.thumbnail;
		document.getElementById("link_capa").value =
			dados.items[0].volumeInfo.imageLinks.thumbnail;
	} catch (err) {
		document.getElementById("capa").src = "";
		document.getElementById("link_capa").value = "";
	}
	document.getElementById("titulo").value = dados.items[0].volumeInfo.title;
	document.getElementById("autor").value = dados.items[0].volumeInfo.authors;
	document.getElementById("editora").value =
		dados.items[0].volumeInfo.publisher;
	document.getElementById("ano").value =
		dados.items[0].volumeInfo.publishedDate;
	document.getElementById("descricao").value =
		dados.items[0].volumeInfo.description;
	document.getElementById("ISBN_input").value =
		dados.items[0].volumeInfo.industryIdentifiers[0].identifier;
	// document.getElementById("categorias").value =
	// 	dados.items[0].volumeInfo.categories;
}

// Funções de envio de dados
async function enviarDadosParaBanco(livro) {
	try {
		const response = await fetch(
			`http://localhost:8080/livros`,
			{
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(livro),
			}
		);

		if (response.ok) {
			alert("Livro cadastrado com sucesso!");
		} else {
			alert("Erro ao cadastrar o livro.");
		}
	} catch (err) {
		console.log("Erro ao enviar dados para o banco", err);
	}
}


async function exemplares(params) {
	
}
const express = require('express');
const path = require('path');
const router = require('./server/router/router.js');  // Seu arquivo de rotas

const app = express();
const port = 3000;

// Servindo arquivos estáticos (HTML, CSS, JS)
app.use(express.static(path.join(__dirname, '/client/src'))); 

// Configurando as rotas
app.use(express.json());
app.use(router);



app.set('port', port);

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}/`);
});





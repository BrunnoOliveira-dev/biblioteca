const express = require("express");
const path = require("path");

const router = express.Router();

const path_views = path.join(__dirname, "../../client/pages");

router.get("/", (req, res) => {
	res.sendFile(path.join(path_views, "home.html"));
});

router.get("/cadastro", (req, res) => {
	res.sendFile(path.join(path_views, "cadastro.html"));
});

router.get("/livro", (req, res) => {
	res.sendFile(path.join(path_views, "livro.html"));
});

module.exports = router;

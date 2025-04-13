const express = require("express");
const router = express.Router();
const path = require("path");

const pages = require("./pages");

router.use("/", pages);

module.exports = router;

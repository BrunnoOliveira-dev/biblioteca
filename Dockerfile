# Usa a imagem oficial do Node.js com Alpine para uma imagem leve
FROM node:18-alpine

# Define o diretório de trabalho
WORKDIR /

# Copia apenas os arquivos necessários para instalar dependências
COPY package*.json ./

# Limpa o cache do npm e instala as dependências de forma otimizada
RUN npm cache clean --force && npm install --omit=dev

# Copia o restante dos arquivos do projeto
COPY . .

# Expõe a porta do servidor
EXPOSE 3000

# Define o comando de inicialização
CMD ["node", "/index.js"]
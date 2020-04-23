FROM node:lts-alpine

# install simple http server for serving static content
RUN npm install -g serve

# make the 'app' folder the current working directory
WORKDIR /app
COPY dist dist
# copy project files and folders to the current working directory (i.e. 'app' folder)

# build app for production with minification
EXPOSE 5000
CMD [ "serve", "-s","dist" ]
cd ../../gui/vue
npm run build
cd ../angular
ng build --prod --base-href boot
cd ../react
npm run build
cd ../../__modules/__vue/vue
mvn clean install
cd ../
docker build -t demo/spring-vue .
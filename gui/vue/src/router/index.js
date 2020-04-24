import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);
let pgPrefix = "/vapp";
const routes = [
  {
    path: pgPrefix + "/login",
    component: () => import(/* webpackChunkName: "login" */ "../Login.vue")
  },
  {
    path: pgPrefix + "/dashboard",
    alias: ["/"],
    component: () =>
      import(/* webpackChunkName: "dashboard" */ "../Dashboard.vue")
  },
  {
    path: pgPrefix + "/data",
    component: () =>
      import(/* webpackChunkName: "search data" */ "../views/SearchData.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  routes
});

export default router;

import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/login",
    component: () => import(/* webpackChunkName: "login" */ "../Login.vue")
  },
  {
    path: "/dashboard",
    alias: ["/"],
    component: () =>
      import(/* webpackChunkName: "dashboard" */ "../Dashboard.vue")
  },
  {
    path: "/data",
    component: () =>
      import(/* webpackChunkName: "search data" */ "../views/SearchData.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  routes
});

export default router;

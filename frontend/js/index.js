window.Vue = require("vue");

import '@ryangjchandler/spruce'
import 'alpinejs'
import '../css/styles.css'
import axios from 'axios'
import router from "./router";

window.axios = axios.create({
    baseURL: `/api`,
    timeout: 1000
});

window.Spruce.store('theme', {
    darkMode: localStorage.darkMode ? localStorage.darkMode : window.matchMedia('(prefers-color-scheme: dark)').matches
});

Vue.component(
    "hello-world",
    require("./components/HelloWorld.vue").default
  );

  Vue.component(
    "products",
    require("./components/Products.vue").default
  );

const app = new Vue({
    router,
    el: "#app"
  });

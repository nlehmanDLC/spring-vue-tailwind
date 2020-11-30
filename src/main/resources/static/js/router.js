import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

let router = new Router({
    mode: "history",
    routes: [
        {
            path: "/products",
            name: "index",
            component: () =>
                import(/* webpackChunkName: "products" */ "./components/ProductIndex.vue")
        },
        {
            path: "/products/:productId",
            name: "product",
            component: () =>
                import(/* webpackChunkName: "products" */ "./components/Product.vue")
        }
    ]
});

export default router;

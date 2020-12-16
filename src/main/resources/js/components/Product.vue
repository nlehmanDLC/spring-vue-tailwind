<template>
  <header class="bg-white shadow dark:bg-gray-700">
    <div
      class="flex items-center justify-between px-4 py-6 mx-auto max-w-7xl sm:px-6 lg:px-8"
    >
      <h1
        class="text-3xl font-bold leading-tight text-gray-900 dark:text-gray-300"
      >
        {{ product.name }}
      </h1>
      <router-link
        to="/products"
        class="p-3 text-base font-medium text-gray-900 rounded-md dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-500"
        >Browse Products</router-link
      >
    </div>
  </header>
</template>

<script>
export default {
  name: "Product",
  data() {
    return {
      product: {},
    };
  },
  computed: {
    productId: function () {
      return this.$route.params.productId;
    },
  },
  methods: {
    loadProduct: function () {
      axios
        .get(`/products/${this.productId}`)
        .then((response) => {
          this.product = response.data;
        })
        .catch((error) => {
          console.log("Error: " + error);
        });
    },
  },
  mounted() {
    this.loadProduct();
  },
};
</script>

<style>
</style>

<template>
  <header class="bg-white dark:bg-gray-700 shadow">
    <div
      class="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8 flex items-center justify-between"
    >
      <h1
        class="text-3xl font-bold leading-tight text-gray-900 dark:text-gray-300"
      >
        {{ product.name }}
      </h1>
      <router-link
        to="/products"
        class="p-3 rounded-md text-base font-medium text-gray-900 dark:text-gray-200 hover:bg-gray-100 dark:hover:bg-gray-500"
        >Browse Products</router-link
      >
    </div>
  </header>
</template>

<script>
export default {
    data() {
        return {
            product: null
        }
    },
  computed: {
    productId: function () {
      return this.$route.params.productId;
    },
  },
  methods: {
    loadProduct: function () {
        console.log('here')
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

<template>
  <div class="pt-6">
    <div class="flex pt-4">
      <!-- Filter button -->
      <transition
        enter-active-class="transition-opacity ease-in-out duration-500"
        enter-class="opacity-0"
        enter-to-class="opacity-100"
        leave-active-class="transition-opacity ease-in-out duration-500"
        leave-class="opacity-100"
        leave-to-class="opacity-0"
      >
        <div v-show="!showFilters" class="relative">
          <div class="absolute top-0 left-0 pt-4 pl-2 flex">
            <button
              id="filterToggle"
              @click="showFilters = true"
              class="rounded-md text-gray-700 dark:text-gray-300 hover:text-gray-800 dark:hover:text-white focus:outline-none focus:ring-2 focus:ring-white"
            >
              <svg
                class="w-6 h-6"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M12 6V4m0 2a2 2 0 100 4m0-4a2 2 0 110 4m-6 8a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4m6 6v10m6-2a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4"
                ></path>
              </svg>
            </button>
          </div>
        </div>
      </transition>
      <!-- Filters -->
      <transition
        enter-active-class="transition-all transform ease-in-out duration-500 sm:duration-700"
        enter-class="-translate-x-full"
        enter-to-class="translate-x-0"
        leave-active-class="transition-all transform ease-in-out duration-500 sm:duration-700"
        leave-class="translate-x-0"
        leave-to-class="-translate-x-full"
      >
        <div class="relative" v-show="showFilters">
          <div class="absolute top-0 right-0 -mr-8 pt-4 pl-2 flex">
            <transition
              enter-active-class="transition-opacity ease-in-out duration-500"
              enter-class="opacity-0"
              enter-to-class="opacity-100"
              leave-active-class="transition-opacity ease-in-out duration-500"
              leave-class="opacity-100"
              leave-to-class="opacity-0"
            >
              <button
                v-show="showFilters"
                @click="showFilters = false"
                class="rounded-md text-gray-700 dark:text-gray-300 hover:text-gray-800 dark:hover:text-white focus:outline-none focus:ring-2 focus:ring-white"
              >
                <span class="sr-only">Close panel</span>
                <svg
                  class="h-6 w-6"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                  aria-hidden="true"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M6 18L18 6M6 6l12 12"
                  />
                </svg>
              </button>
            </transition>
          </div>
          <div class="px-6 py-3 rounded-r bg-gray-300 dark:bg-gray-800">
            <ul>
              <li
                v-for="(category, index) in categories"
                v-bind:key="index"
                class="category px-4 py-2 mt-2 rounded cursor-pointer hover:bg-gray-200 dark:hover:bg-gray-900"
                :class="{
                  'bg-gray-300 dark:bg-gray-600': categoryIsSelected(category),
                }"
                @click="toggleCategory(category)"
              >
                {{ category }}
              </li>
            </ul>
          </div>
        </div>
      </transition>
      <!-- Grid -->
      <div
        class="flex-1 grid grid-cols-1 sm:grid-cols-3 md:grid-cols-4 xl:grid-cols-5 2xl:grid-cols-6 gap-4"
      >
        <router-link
          :to="`/products/${product.id}`"
          v-for="product in filteredProducts"
          v-bind:key="product.id"
          class="flex flex-col justify-center items-center"
        >
          <div>
            <img :src="`https://www.memosamples.com/images/${product.image}`" />
          </div>
          <div>{{ product.name }}</div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-index",
  data() {
    return {
      categories: ["Fabric", "Wallcovering", "Privacy Curtains"],
      products: [],
      selectedCategories: [],
      showFilters: false,
    };
  },
  computed: {
    filteredProducts: function () {
      if (!this.selectedCategories.length) {
        return this.products;
      }
      let selectedCategoriesLower = this.selectedCategories.map((cat) =>
        this.camelize(cat)
      );
      return this.products.filter((product) => {
        return selectedCategoriesLower.indexOf(product.category) !== -1;
      });
    },
  },
  methods: {
    getProducts: function () {
      axios
        .get("/products")
        .then((response) => {
          this.products = response.data;
        })
        .catch((error) => {
          console.log("Error: " + error);
        });
    },
    toggleCategory: function (category) {
      let index = this.selectedCategories.indexOf(category);
      if (index === -1) {
        this.selectedCategories.push(category);
      } else {
        this.selectedCategories.splice(index, 1);
      }
    },
    categoryIsSelected: function (category) {
      return this.selectedCategories.includes(category);
    },
    camelize: function (str) {
      return str
        .toLowerCase()
        .replace(/[^a-zA-Z0-9]+(.)/g, (m, chr) => chr.toUpperCase());
    },
  },
  mounted() {
    this.getProducts();
  },
};
</script>

<style>
</style>

<template>
    <div v-if="notiaddsuccess" id="toast-success"
        class=" fixed flex items-center w-full max-w-xs p-4 mb-4 text-gray-500 bg-white rounded-lg shadow dark:text-gray-400 dark:bg-gray-800 top-4 left-1/2 transform -translate-x-1/2  z-50"
        role="alert">
        <div
            class="inline-flex items-center justify-center flex-shrink-0 w-8 h-8 text-green-500 bg-green-100 rounded-lg dark:bg-green-800 dark:text-green-200">
            <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor"
                viewBox="0 0 20 20">
                <path
                    d="M10 .5a9.5 9.5 0 1 0 9.5 9.5A9.51 9.51 0 0 0 10 .5Zm3.707 8.207-4 4a1 1 0 0 1-1.414 0l-2-2a1 1 0 0 1 1.414-1.414L9 10.586l3.293-3.293a1 1 0 0 1 1.414 1.414Z" />
            </svg>
            <span class="sr-only">Check icon</span>
        </div>
        <div class="ms-3 text-sm font-normal">Item moved successfully.</div>
        <button type="button"
            class="ms-auto -mx-1.5 -my-1.5 bg-white text-gray-400 hover:text-gray-900 rounded-lg focus:ring-2 focus:ring-gray-300 p-1.5 hover:bg-gray-100 inline-flex items-center justify-center h-8 w-8 dark:text-gray-500 dark:hover:text-white dark:bg-gray-800 dark:hover:bg-gray-700"
            data-dismiss-target="#toast-success" aria-label="Close">
            <span class="sr-only">Close</span>
            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
            </svg>
        </button>
    </div>

    <router-link
        class="nav-link text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 "
        :class="{ active: $route.path === '/addproduct' }" to="/addproduct">Add Product</router-link>

    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                    <th scope="col" class="px-6 py-3">
                        Image
                    </th>
                    <th scope="col" class="px-6 py-3">
                        Product Id
                    </th>
                    <th scope="col" class="px-6 py-3">
                            Product Name
                        </th> <th scope="col" class="px-6 py-3">
                            Product Price
                        </th> <th scope="col" class="px-6 py-3">
                            Description
                        </th> <th scope="col" class="px-6 py-3">
                            Manufacture Date
                        </th>
                    <th scope="col" class="px-6 py-3">
                        Action
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="pro in this.products" :value="pro.productId"
                    class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                    <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        
                        <!-- <img class="rounded-full w-16 h-16" :src="pro.image" alt="image description"> -->
                         
                    </th>
                    <td class="px-6 py-4">
                        {{ pro.productId }}
                    </td>
                        <td class="px-6 py-4">
                            {{ pro.productName }}
                        </td>
                        <td class="px-6 py-4">
                            {{ pro.price }}
                        </td>
                        <td class="px-6 py-4">
                            {{ pro.description }}
                        </td>
                        <td class="px-6 py-4">
                            {{ pro.manufactureDate }}
                        </td>
                    <td class="px-6 py-4">
                        <button @click="this.deletepro(pro.productId)" type="button"
                            class="text-white bg-gradient-to-r from-red-400 via-red-500 to-red-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">Delete</button>

                        <button @click="this.movetoupdate(pro.productId)" type="button"
                            class="text-white bg-gradient-to-r from-green-400 via-green-500 to-green-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-green-300 dark:focus:ring-green-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">Update</button>

                    </td>

                </tr>

            </tbody>
        </table>
    </div>
</template>


<script>
import axios from 'axios'
import 'flowbite'
export default {
    data() {
        return {
            notiaddsuccess: false,
            products: [],
            product: {},
            keyword: this.$route.query.keyword || '',
        }

    },
    mounted() {
        this.getAllPro()
        if (this.$route.query.updatesuccess) {
            this.triggerNotification()
        }
      
    

    }, 
    methods: {
        getAllPro() {
            axios.get("http://localhost:8080/product/findAllproduct").then(res => {
                this.products = res.data
            })

        }, search() {
            const cookieValue = Cookies.get('keyword');
            console.log(cookieValue)
              if (cookieValue != null) {

                  axios.get("http://localhost:8080/product/search?keyword=" + cookieValue).then(res => {
                this.products = res.data
            })
            }
           

        },
         deletepro(productId) {
            axios.delete("http://localhost:8080/product/deleteproduct?productId=" + productId).then(res => {
                this.getAllPro();
                this.triggerNotification()
            })
        },
        movetoupdate(productId) {
            //   this.$router.push({
            //     name: "UpdateCategory", //use name for router push
            //     params: { categoryId: categoryId }
            //   });

            this.$router.push({ path: '/updateproduct', query: { productId } });

        },
        triggerNotification() {
            this.notiaddsuccess = true;
            setTimeout(() => {
                this.notiaddsuccess = false;
            }, 2000); // Thông báo sẽ ẩn sau 1 giây
        },
        created() {
            console.log("ok ok")
            this.search()
        }

      

    }
}

</script>

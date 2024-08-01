<template>
    <div>
        <div class="header">
            <button type="button" data-modal-target="crud1-modal4" data-modal-toggle="crud1-modal4"
                class="text-white  bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Add
                New Product</button>
        </div>
        <!-- notification -->
        <transition name="fade">
            <div v-if="showNotificationsuccess" class="fixed top-4 left-1/2 transform -translate-x-1/2  z-50">
                <div id="toast-success3"
                    class="flex items-center w-full max-w-xs p-4 mb-4 text-gray-500 bg-white rounded-lg shadow dark:text-gray-400 dark:bg-gray-800"
                    role="alert">
                    <div
                        class="inline-flex items-center justify-center flex-shrink-0 w-8 h-8 text-blue-500 bg-green-100 rounded-lg dark:bg-green-800 dark:text-green-200">
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
                        data-dismiss-target="#toast-success3" aria-label="Close">
                        <span class="sr-only">Close</span>
                        <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                            viewBox="0 0 14 14">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                        </svg>
                    </button>
                </div>
            </div>
        </transition>
        <!-- notification -->
        <div class="contaiter">
            <transition name="fade">
                <div v-if="showNotification" class="fixed top-4 left-1/2 transform -translate-x-1/2  z-50">
                    <div id="toast-success4"
                        class="flex items-center w-full max-w-xs p-4 mb-4 text-gray-500 bg-white rounded-lg shadow dark:text-gray-400 dark:bg-gray-800"
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
                            <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                viewBox="0 0 14 14">
                                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                            </svg>
                        </button>
                    </div>
                </div>
            </transition>
            <div class="card">


                <div class="card-body">


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
                                        </th>
                                        <th scope="col" class="px-6 py-3">
                                            Price
                                        </th>
                                        <th scope="col" class="px-6 py-3">
                                            Description
                                        </th>
                                        <th scope="col" class="px-6 py-3">
                                            ManufactureDate
                                        </th>
                                    <th scope="col" class="px-6 py-3">
                                        Action
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700"
                                    v-for="(pro,index) in this.products" :key="index">
                                    <th scope="row"
                                        class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                        {{ pro.productId }}
                                    </th>
                                    <td class="px-6 py-4">
                                            {{ pro.productName }}
                                        </td>
                                         <td class="px-6 py-4">
                                            {{ pro.image }}
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

                                        <button @click="deletepro(pro.productId)" type="button"
                                            class="text-white bg-gradient-to-r from-red-400 via-red-500 to-red-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">Delete</button>
                                        <button @click="findprobyid(pro.productId)" data-modal-target="update-modal4"
                                            data-modal-toggle="update-modal4" type="button"
                                            class="text-white bg-gradient-to-r from-green-400 via-green-500 to-green-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-green-300 dark:focus:ring-green-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">Delete</button>

                                    </td>
                                </tr>


                            </tbody>
                        </table>
                    </div>



                </div>

            </div>

            <div id="update-modal4" tabindex="-1" aria-hidden="true"
                class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
                <div class="relative p-4 w-full max-w-md max-h-full">
                    <!-- Modal content -->
                    <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                        <!-- Modal header -->
                        <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
                            <h3 class="text-lg font-semibold text-gray-900 dark:text-white">
                                Create New Product
                            </h3>
                            <button type="button"
                                class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
                                data-modal-toggle="update-modal4">
                                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                    viewBox="0 0 14 14">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                                </svg>
                                <span class="sr-only">Close modal</span>
                            </button>
                        </div>
                        <!-- Modal body -->
                        <form class="p-4 md:p-5" id="formupdatecate3" @submit.prevent="update" enctype="multipart/form-data">

                            <div class="grid gap-4 mb-4 grid-cols-2">
                                <div class="col-span-2">
                                    <label for="id3"
                                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Id</label>
                                    <input v-model="profind.productId" type="text" name="id" id="id3" readonly
                                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                        :placeholder="profind.productId" required="">
                                </div>
                            </div>
                            <div class="grid gap-4 mb-4 grid-cols-2">
                                <div class="col-span-2">
                                    <label for="name3"
                                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
                                    <input v-model="profind.productName" type="text" name="name" id="name3"
                                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                        required="">
                                </div>
                          
           <div class="col-span-2 sm:col-span-1">
                            <label for="price3" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Price</label>
                            <input type="number" v-model="profind.price" name="price" id="price3" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="$2999" required="">
                        </div>
                        <div class="col-span-2 sm:col-span-1">
                            <label for="categoryId3" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Category</label>
                             <select v-model="this.catefind.categoryId" id="categoryId3" name="categoryId"  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500">
                                            <option  v-for="cate in this.categorys" :key="cate.categoryId" v-bind:value="cate.categoryId" :selected="cate.categoryId ===this.catefind.categoryId">{{ cate.categoryName }}</option>
                                        </select>
                        </div>

                                <div class="col-span-2">
                                    <label for="description3" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Product Description</label>
                                    <textarea v-model="profind.description" id="description3" rows="4" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Write product description here"></textarea>                    
                                </div> 
                            </div>
                            <button type="submit"  data-modal-toggle="update-modal4"
                                class="text-white inline-flex items-center bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                <svg class="me-1 -ms-1 w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M10 5a1 1 0 011 1v3h3a1 1 0 110 2h-3v3a1 1 0 11-2 0v-3H6a1 1 0 110-2h3V6a1 1 0 011-1z"
                                        clip-rule="evenodd"></path>
                                </svg>
                                Update new category
                            </button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- end modal updated -->
            <!-- Modal update cate -->

            <div id="crud1-modal4" tabindex="-1" aria-hidden="true"
                class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
                <div class="relative p-4 w-full max-w-md max-h-full">
                    <!-- Modal content -->
                    <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
                        <!-- Modal header -->
                        <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
                            <h3 class="text-lg font-semibold text-gray-900 dark:text-white">
                                Create New Product
                            </h3>
                            <button type="button"
                                class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
                               data-modal-toggle="crud1-modal4">
                                <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                    viewBox="0 0 14 14">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                                </svg>
                                <span class="sr-only">Close modal</span>
                            </button>
                        </div>
                        <!-- Modal body -->
                        <form class="p-4 md:p-5" id="formaddcate4" @submit.prevent="addProduct"
                            enctype="multipart/form-data">

                 
                            <div class="grid gap-4 mb-4 grid-cols-2">
                                <div class="col-span-2">
                                    <label for="name4"
                                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
                                    <input v-model="product.productName" type="text" name="name" id="name4"
                                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500"
                                        required="">
                                </div>
                          
           <div class="col-span-2 sm:col-span-1">
                            <label for="price4" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Price</label>
                            <input type="number" v-model="product.price" name="price" id="price4" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="$2999" required="">
                        </div>
                        <div class="col-span-2 sm:col-span-1">
                            <label for="categoryId4" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Category</label>
                             <select v-model="product.categoryId" id="categoryId4" name="categoryId"  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-500 focus:border-primary-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500">
                                            <option   v-for="cate in this.categorys" :key="cate.categoryId"  :value="cate.categoryId">{{ cate.categoryName }}</option>
                                        </select>
                        </div>

                                <div class="col-span-2">
                                        <label for="description4" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Product Description</label>
                                        <textarea v-model="product.description" id="description4" rows="4" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Write product description here"></textarea>                    
                                    </div> 

                                       <div class="col-span-2">
    <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="image4">Upload file</label>
      <input  class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400" aria-describedby="user_avatar_help" id="image4" type="file">
     </div> 
                            </div>
                            <button type="submit" data-modal-toggle="crud1-modal4"
                                class="text-white inline-flex items-center bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                                <svg class="me-1 -ms-1 w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M10 5a1 1 0 011 1v3h3a1 1 0 110 2h-3v3a1 1 0 11-2 0v-3H6a1 1 0 110-2h3V6a1 1 0 011-1z"
                                        clip-rule="evenodd"></path>
                                </svg>
                                Add new category
                            </button>
                        </form>
                    </div>
                </div>
            </div>


            <!-- end modal add cate -->

        </div>
    </div>
</template>

<script>
import axios from 'axios';

import 'flowbite';

export default {
    name: 'categorys',
    data() {
        return {
            showNotification: false,
            showNotificationsuccess: false,
            categorys: [],
            products: [],
            catefind: {
                categoryId: '',
                categoryName: '',
                productList:[]
            },
            profind: {
                productId: '',
                productName: '',
                image: '',
                price: '',
                description: '',
                manufactureDate: '',
                categoryId: ''
            },
            product: {
                productName: '',
                image: '',
                price: '',
                description: '',
                manufactureDate: '',
                categoryId: ''
            },
            productdto: {
                 productName: '',
                image: '',
                price: '',
                description: '',
                manufactureDate: '',
                categoryId:''
            }
        }
    },
    mounted() {
        this.getAllPro();
        this.getAllCate();


    },
    methods: {
        getAllCate() {
            axios.get("http://localhost:8080/category/findAllcate").then(res => {
                this.categorys = res.data
                console.log(res)
            })

        },
        getAllPro() {
            axios.get("http://localhost:8080/product/findAllproduct").then(res => {
                this.products = res.data
                console.log(res)
            })

        },
        deletepro(productId) {
            axios.delete("http://localhost:8080/product/deleteproduct?productId=" + productId).then(res => {
                this.getAllPro();
                this.getAllCate();
                this.triggerNotification()
            })
        },
        triggerNotification() {
            this.showNotification = true;
            setTimeout(() => {
                this.showNotification = false;
            }, 2000); // Thông báo sẽ ẩn sau 1 giây
        },
        triggerNotificationupdate() {
            this.showNotificationsuccess = true;
            setTimeout(() => {
                this.showNotificationsuccess = false;
            }, 2000); // Thông báo sẽ ẩn sau 1 giây
        },
        findprobyid(productId) {
            axios.get("http://localhost:8080/product/findproductbyId?productId=" + productId).then(res => {
              
                this.findcatebyProduct(productId)
                  this.profind = res.data
            })
        },
        // Thêm một category mới
        update() {
            let uri = 'http://localhost:8080/product/updateproduct';
            axios.post(uri, this.profind).then(response => {
                // Đóng modal
                // this.closeModal();
                this.triggerNotification()
                // Làm mới danh sách các category
                this.getAllPro();
                this.getAllCate();

            }).catch(error => {
                console.error('Error adding category:', error);
            });
        },
        // Thêm một category mới
        addProduct() {
            let uri = 'http://localhost:8080/product/addproduct';
            axios.post(uri, this.product).then(response => {
                // Đóng modal
                // Làm mới danh sách các category
                this.getAllPro();
                this.getAllCate();

                // Xóa dữ liệu trong form
            }).catch(error => {
                console.error('Error adding category:', error);
            });
        },
        findcatebyProduct(productId) {
             axios.get("http://localhost:8080/category/findcategorybyproId?productId=" + productId).then(res => {
                this.catefind = res.data
            })
        },



    }
}
</script>

<style scoped>/* Add your styles here */</style>

<template>


    <form class="max-w-md mx-auto" @submit.prevent="submitForm" >
      <div class="relative z-0 w-full mb-5 group">
          <input v-model="product.productName" type="text" name="floating_email" id="floating_email" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required />
          <label for="floating_email" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 rtl:peer-focus:left-auto peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Product Name</label>
      </div>
      <div class="relative z-0 w-full mb-5 group">
          <input  v-model="product.description" type="text" name="floating_password" id="floating_password" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required />
          <label for="floating_password" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Description</label>
      </div>

      <div class="grid md:grid-cols-2 md:gap-6">
        <div class="relative z-0 w-full mb-5 group">
            <input  v-model="product.price" type="number" name="floating_first_name" id="floating_first_name" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required />
            <label for="floating_first_name" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Price</label>
        </div>
        <div class="relative z-0 w-full mb-5 group">
            
    <div class="relative max-w-sm">
      <div  class="absolute inset-y-0 start-0 flex items-center ps-3.5 pointer-events-none">
        <svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
          <path d="M20 4a2 2 0 0 0-2-2h-2V1a1 1 0 0 0-2 0v1h-3V1a1 1 0 0 0-2 0v1H6V1a1 1 0 0 0-2 0v1H2a2 2 0 0 0-2 2v2h20V4ZM0 18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V8H0v10Zm5-8h10a1 1 0 0 1 0 2H5a1 1 0 0 1 0-2Z"/>
        </svg>
      </div>
       <input v-model="product.manufactureDate" datepicker id="default-datepicker" type="date" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full ps-10 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Select date"/>
        
        </div>
     </div>
      </div>
      <div class="relative z-0 w-full mb-5 group">
                        <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="user_avatar">Upload file</label>
              <input class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400" aria-describedby="user_avatar_help" id="user_avatar" @change="handleFileChange" type="file">
      
              </div>
              
               <div class="relative z-0 w-full mb-5 group">
                      <label for="categoryId" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Select an option</label>
      <select v-model="product.categoryId" id="categoryId" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
        <option v-for="cate in this.categorys" :value="cate.categoryId" :key="cate.categoryId" >{{cate.categoryName}}</option>
      </select>
              </div>
      <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Submit</button>
    </form>

</template>

<script>
import axios from 'axios'
import 'flowbite'
import { format } from 'date-fns';
import { onMounted } from 'vue';
import VueTailwindDatepicker from "vue-tailwind-datepicker";
export default {
    data() {
        return {
            product: {
                productName: '',
                price: '',
                description: '',
                manufactureDate: '',
                categoryId: ''
            },
            categorys: [],
            selectedFile: null
        }

    },
    mounted() {

        this.getAllCate();
    },
    methods: {
       
        // Thêm một category mới
        addProduct() {
            let uri = 'http://localhost:8080/product/addproduct';
            axios.post(uri, this.product).then(response => {
                // Đóng modal
                // Làm mới danh sách các category
                  this.$router.push({ path: '/product', query: { updatesuccess: true } });
                    

                // Xóa dữ liệu trong form
            }).catch(error => {
                console.error('Error adding category:', error);
            });
        }, getAllCate() {
            axios.get("http://localhost:8080/category/findAllcate").then(res => {
                this.categorys = res.data
            })

        }, handleFileChange(event) {
            this.selectedFile  = event.target.files[0];
          

        },
        async submitForm() {

            this.product.manufactureDate = format(new Date(this.product.manufactureDate), 'yyyy-MM-dd');
            
            const formData = new FormData();
            formData.append('product', JSON.stringify(this.product));
            formData.append('image', this.selectedFile);

            try {
                const response = await axios.post('http://localhost:8080/product/addproduct', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                });
                console.log(response.data);
            } catch (error) {
                console.error('Error uploading product', error);
            }
            this.$router.push({ path: '/product', query: { updatesuccess: true } });

        }

         

    }
};



    
</script>

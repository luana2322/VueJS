<template>
    <div>
       <div class="contaiter">
        <div class="card">
            <div class="card-header">
                <h4>
                    Students
                    <RouterLink to="/"  class="btn btn-primary float-end">
                            AddCategory
                    </RouterLink>
                </h4>
            </div>

            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody v-if="this.categorys.length > 0 ">
                        <tr v-for="(category,index) in this.categorys" :key="index" >
                                <td>{{ category.categoryId }}</td>
                                <td>{{ category.categoryName }}</td>
                                <td>
                        <RouterLink to="/"  class="btn btn-success">
                                Edit
                        </RouterLink>

                        <button type="button" class="btn btn-danger">
                                    Delete
                        </button>
                                </td>
                        
                        </tr>
                    </tbody>
                    <tbody v-else>
                        <td colspan="3">Loading...</td>
                    </tbody>
                </table>
            </div>

        </div>
       </div>
    </div>
</template>

<script>
import axios from 'axios';


export default {
    name: 'categorys',
    data() {
        return {
            categorys:[]
        }
    },
    mounted() {
        this.getAllCate();
        
    },
    methods: {
        getAllCate() {
            axios.get("http://localhost:8080/category/findAllcate").then(res => {
                this.categorys = res.data
        console.log(res)
            })
            
        }
    }
}
</script>

<style scoped>
/* Add your styles here */
</style>

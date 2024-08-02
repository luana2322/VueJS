
<script setup>
import Product from './components/product/Product.vue'
import Category from './components/category/Category.vue'
import Navbar from './components/Navbar.vue'

import Bottom from './components/Bottom.vue'
import 'flowbite'; 
</script>



<template>
    <Navbar />

    <router-view/>

    <!-- <Bottom />x -->
   

</template>

<style></style>
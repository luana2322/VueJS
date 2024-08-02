import { createRouter, createWebHistory } from 'vue-router';
import Category from '../category/Category.vue';
import Product from '../product/Product.vue';
import AddCategory from '../category/AddCategory.vue';
import UpdateCategory from '../category/UpdateCategory.vue';
import AddProduct from '../product/AddProduct.vue';
import UpdateProduct from '../product/UpdateProduct.vue';

const routes = [
    {
        path: '/',
        redirect: '/homepage'
    },
    {
        path: '/category',
        name: 'Category',
        component: Category
    },
    {
        path: '/product',
        name: 'Product',
        component: Product
    },
    {
        path: '/addcategory',
        name: 'AddCategory',
        component: AddCategory,
        meta: {
            auth: true
        }
    }, {
        path: '/updatecategory',
        name: 'UpdateCategory',
        component: UpdateCategory,
        meta: {
            auth: true
        }
    }, {
        path: '/addproduct',
        name: 'AddProduct',
        component: AddProduct,
        meta: {
            auth: true
        }
    }, {
        path: '/updateproduct',
        name: 'UpdateProduct',
        component: UpdateProduct,
        meta: {
            auth: true
        }
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
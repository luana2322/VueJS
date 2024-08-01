import { createRouter, createWebHistory } from 'vue-router';
import Category from '../Category.vue';
import Product from '../Product.vue';
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
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
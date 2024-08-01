import { createApp } from 'vue'
// import './assets/main.css'

import './style.css'

import App from './App.vue'

import router from './components/router'

createApp(App).use(router).mount('#app')
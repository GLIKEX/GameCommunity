import Vue from "vue";
import VueRouter from "vue-router";

import Home from "@/views/Home.vue";
import classify from "@/views/classify.vue";
import Forum from "@/views/Forum.vue";
import FrontPage from "@/views/FrontPage.vue";

Vue.use(VueRouter)

const routes = [
    {
        path:'/',
        redirect:'/home'
    },{
        path: '/home',
        component:Home,
        children:[
            {
                path: '',
                redirect:'front'
            },
            {
                path: 'front',
                component: FrontPage
            },
            {
                path: 'classify',
                component: classify
            },{
                path: 'forum',
                component: Forum
            }
        ]
    },

]
const router = new VueRouter({
    routes,
    mode:'hash'
})

export default router
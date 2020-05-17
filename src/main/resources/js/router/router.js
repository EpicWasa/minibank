import Vue from 'vue'
import VueRouter from 'vue-router'
import AccountList from 'components/AccountList.vue'
import AccountsPage from 'components/AccountsPage/AccountsPage.vue'
import ContractsPage from "components/ContractsPage/ContractsPage.vue";

Vue.use(VueRouter);

const routes = [
    {path:'/', component:AccountList},
    {path:'/accounts', component:AccountsPage},
    {path:'/contracts', component:ContractsPage},
    {path:'*', component:AccountList},

];

export default new VueRouter({
    mode: 'history',
    routes
})
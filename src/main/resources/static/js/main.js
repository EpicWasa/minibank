import Vue from 'vue'
import App from './pages/App.vue'
import Vuetify from 'vuetify'
import '@babel/polyfill'
import 'vuetify/dist/vuetify.min.css'
import store from "store/store";

Vue.use(Vuetify,{ iconfont: 'mdiSvg' });
new Vue({
    el: '#app',
    store: store,
    vuetify: new Vuetify(),
    render: a => a(App)
});


/*
var customerApi = Vue.resource('/api/customer{/id}');
var accountApi = Vue.resource('/api/accounts{/id}');

Vue.component('account-row',{
    props: ["account"],
    template: '<div >' +
        '{{account.amount}} ' +
        '{{account.currency.name}}'+
        '</div>'
});

Vue.component('account-form',{
    props:['accounts'],
   data: function(){
       return{
           amount: '',
           currency: '',
           customer: ''
       }
   },
    template:
    '<div>'+
        '<input type="text" placeholder="amount" v-model="amount"/>'+
        '<input type="text" placeholder="currencyId" v-model="currency"/>'+
        '<input type="text" placeholder="customerId" v-model="customer"/>'+
        '<input type="button" value = "save" @click="save"/>'+
    '</div>',
    methods:{
       save: function () {
           var account = {
               'amount': this.amount,
               'currency': this.currency,
               'customer': this.customer,

           };
           accountApi.save({}, account).then(result =>
                                result.json().then( data => {
                                    this.accounts.push(data);
                       this.amount = '';
                       this.currency='';
                       this.customer = '';

           }))

       }
    }


});

Vue.component('account-list', {
    props:['accounts'],
    template: '<div>' +
        '<account-form :accounts = "accounts"/>'+
        '<account-row v-for = "account in accounts" :account="account" :key="account.id" /></div>',

});


var app = new Vue({
    el: '#app',
    data: {
        profile: frontendData.profile,
        accounts: frontendData.accounts,
        cards: frontendData.cards,
    },
    template: '<div>'+
        '<div>'+
            '<div v-if = "!profile"><a href="/login">Sign in</a></div>'+
            '<div v-else ><a href="/logout">Log out</a>{{profile.name}}</div>'+
        '</div>'+
    '</div>',

    created: function () {

        // accountApi.get({id:'1'}).then(result =>
        // result.json().then(data =>
        // data.forEach(account => this.accounts.push(account))
    // )
    // )
    }
})*/

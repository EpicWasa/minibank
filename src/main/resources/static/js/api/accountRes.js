import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource);

const accounts = Vue.resource('api/accounts{/id}');

export default {
    add: account => accounts.save({}, account),
    update: account => accounts.update({id: account.id}, account),
    remove: id => accounts.remove({id})
}
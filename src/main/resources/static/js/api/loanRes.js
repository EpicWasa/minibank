import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource);

const loans = Vue.resource('api/loans{/id}');

export default {
    add: loan => loans.save({}, loan),
    update: loan => loans.update({id: loan.id}, loan),
    remove: id => loans.remove({id})
}
<template>
    <div class=" my-6">
        <p class="text-center" >
            Available Accounts:
        </p>
        <account-page-account-card v-for="account in accounts" :account="account"></account-page-account-card>
        <div class="text-center">
            <create-account-dialog></create-account-dialog>
        </div>
        <br/>
        <p class="text-center">
            Available Cards:
        </p>
        <card-card  v-for="card in cards" :card="card"></card-card>
        <div class="text-center">
            <create-card-dialog></create-card-dialog>
        </div>
    </div>
</template>

<script>

    import {mapState} from 'vuex'
    import AccountPageAccountCard from "./AccountPageAccountCard.vue";
    import CardCard from "./CardCard.vue";
    import CreateAccountDialog from "./CreateAccountDialog.vue";
    import CreateCardDialog from "./CreateCardDialog.vue";

    export default {
        computed: mapState(['accounts', 'cards']),
        components: {
            AccountPageAccountCard,
            CardCard,
            CreateAccountDialog,
            CreateCardDialog,
        },
        methods: {
            createCard(){

            }
        }
    }
</script>

<style scoped>

</style>
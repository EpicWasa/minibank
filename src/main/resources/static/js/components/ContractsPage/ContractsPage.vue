<template>
    <div class=" my-6">
        <p class="text-center" >
            Current Deposits:
        </p>
        <deposit-card v-for="deposit in deposits" :deposit="deposit"></deposit-card>
        <div class="text-center">
            <create-deposit-dialog></create-deposit-dialog>
        </div>
        <br/>
        <p class="text-center">
            Current Loans:
        </p>
        <loan-card  v-for="loan in loans" :loan="loan"></loan-card>
        <div class="text-center">
            <create-loan-dialog></create-loan-dialog>
        </div>
    </div>
</template>

<script>

    import {mapState} from 'vuex'
    import DepositCard from "./DepositCard.vue";
    import CreateDepositDialog from "./CreateDepositDialog.vue";
    import LoanCard from "./LoanCard.vue";
    import CreateLoanDialog from "./CreateLoanDialog.vue";

    export default {
        computed: mapState(['accounts', 'cards', 'deposits', 'loans']),
        components: {
            CreateLoanDialog,
            LoanCard,
            CreateDepositDialog,
            DepositCard,

        },
        methods: {
            createCard(){

            }
        }
    }
</script>

<style scoped>

</style>
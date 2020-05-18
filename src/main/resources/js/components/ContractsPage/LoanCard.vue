<template>
    <v-card
            class="mx-auto my-6"
            max-width="344"
            outlined
    >
        <v-list-item three-line>
            <v-list-item-content>
                <v-list-item-title >{{loan.rate.rate}} %  {{loan.account.currency.name}}</v-list-item-title>
                <v-list-item-subtitle>Sum: {{loan.initialSum}} </v-list-item-subtitle>
                <v-list-item-subtitle>Signing Date: {{loan.dateOfSigning}}</v-list-item-subtitle>
                <v-list-item-subtitle>Expiration Date: {{loan.dateOfExpiration}}</v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>
    </v-card>
</template>

<script>


    export default {

        props:['loan'],
        data(){
            return{

            }
        }
    }

</script>

<style>


</style>
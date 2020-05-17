<template>
    <v-card
            class="mx-auto my-6"
            max-width="344"
            outlined
    >
        <v-list-item three-line>
            <v-list-item-content>
                <v-list-item-title >{{deposit.rate.rate}} %  {{deposit.account.currency.name}}</v-list-item-title>
                <v-list-item-subtitle>Sum: {{deposit.initialSum}} </v-list-item-subtitle>
                <v-list-item-subtitle>Signing Date: {{deposit.dateOfSigning}}</v-list-item-subtitle>
                <v-list-item-subtitle>Expiration Date: {{deposit.dateOfExpiration}}</v-list-item-subtitle>
            </v-list-item-content>
        </v-list-item>



    </v-card>

</template>

<script>


    export default {

        props:['deposit'],
        data(){
            return{


            }
        }
    }

</script>

<style>


</style>
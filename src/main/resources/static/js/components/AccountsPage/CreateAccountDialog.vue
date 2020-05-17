<template>
    <v-row justify="center">
        <v-dialog v-model="dialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">New Account</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline" >New Account</span>
                </v-card-title>
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col cols="12">
                                <v-text-field label="AccountName*" v-model="accountName" required></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-select
                                        v-model="currencyName"
                                        :items="getCardNames()"
                                        label="Currency*"
                                        required
                                ></v-select>
                            </v-col>
                        </v-row>
                    </v-container>
                    <small>*indicates required field</small>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
                    <v-btn color="blue darken-1" text @click="save" >Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-row>
</template>

<script>
    import {mapState} from 'vuex'
    import { mapActions } from 'vuex'
    import router from "router/router";

    export default {
        computed: mapState(['accounts', 'cards', 'currencies', "profile"]),
        data()  {
            return {
                accountName: '',
                currencyName: ' ',
                dialog: false,
            }
        },
        methods: {
            ...mapActions(['addAccountAction', ]),
            getCardNames(){
                var names = [];
                this.currencies.map(elem => {
                    names.push( elem.name);
                });

                return names;
            },
            save() {
                if(!(this.accountName && this.currencyName)||this.currencyName===' '){
                    return;
                }
                console.log(this.currencyName);
                const account = {
                    name: this.accountName,
                    currency: this.currencies.filter(elem=>elem.name===this.currencyName)[0],
                    amount: 1500,
                    user: this.profile,
                };

                this.addAccountAction(account);
                this.dialog = false;
                router.go();
            },


    }

    }
</script>

<style scoped>

</style>
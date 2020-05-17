<template>
    <v-row justify="center">
        <v-dialog v-model="dialog" persistent max-width="600px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">New Loan</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline" >New Loan</span>
                </v-card-title>
                <v-card-text>
                    <v-container>
                        <v-row>
                            <v-col cols="12">
                                <v-text-field label="Sum*" v-model="initialSum" type="number"  required></v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-select
                                        v-model="accountName"
                                        :items="this.accounts.map(item=>item.name)"
                                        label="Account*"
                                        required
                                ></v-select>
                            </v-col>
                            <v-col cols="12">
                                <v-select
                                        v-model="rateName"
                                        :items="this.getRates()"
                                        label="Duration*"
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
        computed: mapState(['accounts', 'cards', 'currencies', "profile", 'rates']),
        data()  {
            return {
                accountName: ' ',
                rateName: ' ',
                dialog: false,
                initialSum: '',
            }
        },
        watch:{
            accountName: function () {
                this.rateName = ' ';
            }
        },
        methods: {
            ...mapActions(['addLoanAction', ]),
            getCardNames(){
                var names = [];
                this.currencies.map(elem => {
                    names.push( elem.name);
                });

                return names;
            },
            save() {
                if(!this.initialSum || this.rateName===' '|| this.accountName===' ' || this.initialSum<1){
                    return;
                }
                const loan = {
                    initialSum: this.initialSum,
                    account: this.accounts.filter(elem=>elem.name===this.accountName)[0],
                    rate: this.rates.filter(item=> item.duration+" months "+item.rate+"%" ===this.rateName)[0],
                };

                this.addLoanAction(loan);
                this.dialog = false;
                router.go();
            },

            getRates(){
                let currRates= [];
                if(this.accountName!==' ') {
                    let acc = this.accounts.filter(elem=>elem.name===this.accountName)[0];
                    console.log(acc.currency);
                    currRates = this.rates.filter(item=>item.currency.name === acc.currency.name&&item.type==='loan');
                }
                return currRates.map(item=>item.duration+" months "+item.rate+"%");
            }


    }

    }
</script>

<style scoped>

</style>
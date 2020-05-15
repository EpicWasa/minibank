<template>
    <div >
        <account-card  v-for="account in accounts" :account="account" :cards="f(account)"></account-card>
    </div>
</template>

<script>
    import AccountCard from 'components/AccountCard.vue'
    export default {
        props: ['accounts', 'cards'],
        components: {
            AccountCard
        },
        // data(){
        //     return{
        //         accounts,
        //         cards,
        //     }
        // },
        methods: {
            f(account) {
                var relatedCards = [];
                this.cards.map(elem => {
                    if (elem.account.id === account.id) {
                        relatedCards.push( elem);
                    }
                });
                return relatedCards;
            }
        }
    }

</script>

<style>


</style>


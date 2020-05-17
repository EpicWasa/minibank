import Vue from 'vue'
import Vuex from 'vuex'
import accountApi from 'api/accountRes'
import cardApi from 'api/cardRes'
import depositApi from 'api/depositRes'
import loanApi from 'api/loanRes'

Vue.use(Vuex);

export default new Vuex.Store({

    state:{
        currencies: frontendData. currencies,
        profile: frontendData.profile,
        accounts: frontendData.accounts,
        cards: frontendData.cards,
        loans: frontendData.loans,
        deposits: frontendData.deposits,
        rates: frontendData.rates,
    },
    mutations:{
        addAccountMutation(state, account){
            state.accounts= [
                ...state.accounts,
                account,
            ]
        },
        addCardMutation(state, card){
            state.cards= [
                ...state.cards,
                card,
            ]
        },
        addDepositMutation(state, deposit){
            state.deposits= [
                ...state.deposits,
                deposit,
            ]
        },
        addLoanMutation(state, loan){
            state.loans= [
                ...state.loans,
                loan,
            ]
        },
    },
    actions:{
        async addAccountAction({commit}, account){
            const result = await accountApi.add(account);
            const data = await result.json();
            const index = this.accounts.findIndex(item=>item.id === data.id);
            if(index>-1){
                this.accounts.splice(index, 1, data);
            }else{
               commit('addAccountMutation',data);
            }

        },
        async addCardAction({commit}, card){
            const result = await cardApi.add(card);
            const data = await result.json();
            const index = this.accounts.findIndex(item=>item.id === data.id);
            if(index>-1){
                this.cards.splice(index, 1, data);
            }else{
                commit('addCardMutation', data);
            }
        },
        async addDepositAction({commit}, deposit){
            const result = await depositApi.add(deposit);
            const data = await result.json();
            const index = this.deposits.findIndex(item=>item.id === data.id);
            if(index>-1){
                this.deposits.splice(index, 1, data);
            }else{
                commit('addDepositMutation', data);
            }
        },
        async addLoanAction({commit}, loan){
            const result = await loanApi.add(loan);
            const data = await result.json();
            const index = this.loans.findIndex(item=>item.id === data.id);
            if(index>-1){
                this.loans.splice(index, 1, data);
            }else{
                commit('addLoanMutation', data);
            }
        },
    }

})
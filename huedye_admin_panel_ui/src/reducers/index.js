import history from "../history";


const initialState = {
    clients: [],
    currentUser: 'zhopa',
    currentClient: null,
    currentVisit: null
}


export const getClient = (id) => (dispatch) => {
    return fetch(`/api/clients/getClient/${id}`, {
        method: 'get'
    }).then(function (response) {
        if(response.status === 200){
            return response.json();
        }
    }).then(function (response) {
        return dispatch({
            type: 'GET_CLIENT_SUCCESS',
            data: response
        })
    })

}

export const getClients = (filter) => (dispatch) => {
    return fetch(`/api/clients/getAll?filter=${filter}`, {  //add filters: all, completed, upcoming, didn`t show up
        method: 'get'
    }).then(function (response) {
        if(response.status === 200){
            return response.json();
        }
    }).then(function (response) {
        return dispatch({
            type: 'GET_CLIENTS_SUCCESS',
            data: response
        })
    })

}

export const addClient = (values) => (dispatch) => {

    return fetch('/api/clients/addClient', {
        method: 'post',
        body: JSON.stringify(values),
        headers: {'content-type': 'application/json'}

    }).then(function (response) {
        if(response.status === 200){
            return response.json();
        }
    }).then(function (id) {
        history.push(`client/${id}`)
    })

}

export const addVisit = (values) => (dispatch, getState) => {
    let currentState = getState()
    let currentClientId = currentState.mainReducer.currentClient.id
    let data = {...values, clientId: currentClientId}
    return fetch('/api/visits/addVisit', {
        method: 'post',
        body: JSON.stringify(data),
        headers: {'content-type': 'application/json'}

    }).then(function (response) {
        if(response.status === 200){
            return dispatch(getClient(currentClientId))
        }
    })
}

export const getVisit = (id) => (dispatch) => {
    return fetch(`/api/visits/getVisit/${id}`, {
        method: 'get'
    }).then(function (response) {
        if(response.status === 200){
            return response.json();
        }
    }).then(function (response) {
        return dispatch({
            type: 'GET_VISIT_SUCCESS',
            data: response
        })
    })

}


const reducer = (state = initialState, action) => {
    switch (action.type) {
        case 'GET_CLIENT_SUCCESS':
            return {
                ...state,
                currentClient: action.data
            };
            case 'GET_CLIENTS_SUCCESS':
                return{
                    ...state,
                    clients: action.data
                };
            case 'GET_VISIT_SUCCESS':
                return{
                ...state,
                currentVisit: action.data
                };    
        default:
            return state;    
    }
}


export default reducer;
import history from "../history";


const initialState = {
    clients: [],
    currentUser: 'zhopa',
    currentClient: null
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

export const getClients = () => (dispatch) => {
    return fetch('/api/clients/getAll', {
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

// export const addVisit = (values) => {
//     let visit = {
//         id: values.id,
//         date: values.date,
//         title: values.title,
//         cost: values.cost
//     }

//     return {
//         type: 'ADD_VISIT',
//         data: visit
//     }
// }

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
        default:
            return state;    
    }
}


export default reducer;
import React, { useEffect } from 'react'
import { useDispatch } from 'react-redux'
import { change, Field, reduxForm } from 'redux-form'

const required = value => value ? undefined : 'Required'
const renderField = ({ input, label, type, meta: { touched, error, warning } }) => (
    <div>
      <label>{label}</label>
      <div>
        <input {...input} placeholder={label} type={type}/>
        <br/>
        {touched && ((error && <span style={{color: "red"}}>{error}</span>) || (warning && <span>{warning}</span>))}
      </div>
    </div>
  )

const AddClientForm = ({ handleSubmit, pristine, reset, submitting, client }) => {
  const dispatch = useDispatch()
    useEffect(() => {
        if(client){
            dispatch(change('addClient', "name", client.name))
            dispatch(change('addClient', "phone", client.phone))
        }
    }, [client])
  
  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>ФИО</label>
        <div>
          <Field
            name="name"
            component={renderField}
            type="text"
            placeholder="ФИО"
            validate={[required]}
        
          />
        </div>
      </div>
      <div>
        <label>Телефон</label>
        <div>
          <Field
            name="phone"
            component="input"
            type="text"
          />
        </div>
      </div>
      <div>
        <button type="submit" disabled={pristine || submitting}>
          Submit
        </button>
        <button type="button" disabled={pristine || submitting} onClick={reset}>
          Clear Values
        </button>
      </div>
    </form>
  )
}

export default reduxForm({form: 'addClient'})(AddClientForm)
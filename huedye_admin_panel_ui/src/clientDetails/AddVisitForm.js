import React from 'react'
import { change, Field, reduxForm } from 'redux-form'
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { registerLocale, setDefaultLocale } from "react-datepicker";
import ru from 'date-fns/locale/ru';

registerLocale('ru', ru)

const required = value => value ? undefined : 'Required'
const renderField = ({ input, label, type, meta: { touched, error, warning } }) => (
    <div>
        <label>{label}</label>
        <div>
            <input {...input} placeholder={label} type={type} />
            <br />
            {touched && ((error && <span style={{ color: "red" }}>{error}</span>) || (warning && <span>{warning}</span>))}
        </div>
    </div>
)

const renderDatePicker = ({ input, placeholder, defaultValue, meta: { dispatch, form, touched, error } }) => (
    <div>
        <DatePicker
            {...input}
            dateFormat="dd/MM/yyyy"
            onChange={
                (date) => {
                    let dateTransformed = new Date(date.getTime() - date.getTimezoneOffset() * 60000)
                    dispatch(change(form, input.name, dateTransformed))
                }
            }
            selected={input.value}
            locale="ru"
        />
        {touched && error && <span>{error}</span>}
    </div>
);

const AddVisitForm = props => {
    const { handleSubmit, pristine, reset, submitting } = props
    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Дата</label>
                <div>
                    <Field
                        name="date"
                        component={renderDatePicker}
                        type="text"
                        validate={[required]}

                    />
                </div>
            </div>
            <div>
                <label>услуга</label>
                <div>
                    <Field
                        name="title"
                        component="input"
                        type="text"
                    />
                </div>
            </div>
            <div>
                <label>стоимость</label>
                <div>
                    <Field
                        name="cost"
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

export default reduxForm({ form: 'addVisit' })(AddVisitForm)
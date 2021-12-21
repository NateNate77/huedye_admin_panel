import React from 'react'
import { change, Field, reduxForm } from 'redux-form'
import "react-datepicker/dist/react-datepicker.css";
import { useDispatch } from 'react-redux';



const ProcedureForm = ({ handleSubmit, pristine, reset, submitting, canEdit, procedure, form }) => {
    const dispatch = useDispatch()
    React.useEffect(() => {
        if(procedure){
            dispatch(change(form, "conditionBefore", procedure.conditionBefore))
            dispatch(change(form, "description", procedure.description))
            dispatch(change(form, "conditionAfter", procedure.conditionAfter))
            dispatch(change(form, "comment", procedure.comment))
        }
    }, [procedure])

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Исходные данные</label>
                <div>
                    <Field
                        name="conditionBefore"
                        component="input"
                        type="text"
                        disabled={!canEdit}
                    />
                </div>
            </div>
            <div>
                <label>Описание процедуры</label>
                <div>
                    <Field
                        name="description"
                        component="input"
                        type="text"
                        disabled={!canEdit}
                    />
                </div>
            </div>
            <div>
                <label>Результат</label>
                <div>
                    <Field
                        name="conditionAfter"
                        component="input"
                        type="text"
                        disabled={!canEdit}
                    />
                </div>
            </div>
            <div>
                <label>Комментарий</label>
                <div>
                    <Field
                        name="comment"
                        component="input"
                        type="text"
                        disabled={!canEdit}
                    />
                </div>
            </div>
            {canEdit && <div>
                <button type="submit" disabled={pristine || submitting}>
                    Submit
        </button>
                <button type="button" disabled={pristine || submitting} onClick={reset}>
                    Clear Values
        </button>
            </div>}
        </form>
    )
}

export default reduxForm({})(ProcedureForm)
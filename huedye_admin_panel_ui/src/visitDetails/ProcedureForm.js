import React from 'react'
import { change, Field, reduxForm } from 'redux-form'
import "react-datepicker/dist/react-datepicker.css";
import { useDispatch } from 'react-redux';
import { deleteProcedure, editProcedure } from '../reducers';
import { Button } from '@mui/material';



const ProcedureForm = ({ handleSubmit, pristine, reset, submitting, canEdit, procedure, form, cancel, visitId }) => {

    const resetValues = () => {
        if(procedure){
        dispatch(change(form, "conditionBefore", procedure.conditionBefore))
            dispatch(change(form, "description", procedure.description))
            dispatch(change(form, "conditionAfter", procedure.conditionAfter))
            dispatch(change(form, "comment", procedure.comment))
        }
    }
    const dispatch = useDispatch()
    React.useEffect(() => {
            resetValues()
    }, [procedure])

    const handleCancel = () => {
        resetValues()
        if(cancel){
            cancel()
        }
    }
  

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
            {canEdit && <div style={{marginTop: '10px'}}>
                <Button style={{marginRight: '5px'}} variant="outlined" type="submit" disabled={pristine || submitting}>
                    Submit
                    
                </Button>
                <Button variant="outlined" type="button" onClick={handleCancel}>
                     Галя, отмена!!
                </Button>
            </div>}
        </form>
    )
}

export default reduxForm({})(ProcedureForm)
import '../App.css';
import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {useDispatch, useSelector} from 'react-redux';
import { withRouter, useParams } from 'react-router';
import {deleteProcedure, editProcedure, getVisit} from '../reducers/index'
import AddVisit from '../clientDetails/AddVisit';
import { Link } from 'react-router-dom';
import ProcedureForm from './ProcedureForm';
import AddProcedure from './AddProcedure';
import { Grid, IconButton } from '@mui/material';
import ClearIcon from '@mui/icons-material/Clear';
import EditIcon from '@mui/icons-material/Edit';


const Visit = (match) => {

    const [editMap, setEditMap] = React.useState([])

    const dispatch = useDispatch()
    let { visitId } = useParams()
    let currentVisit = useSelector(state => state.mainReducer.currentVisit)
    React.useEffect(() => {
        if(visitId){
            dispatch(getVisit(visitId))
        }
    }, [visitId])

  React.useEffect(() => {
    if (currentVisit && currentVisit.procedureRows.length > 0) {
      //currentVisit.procedureRows.forEach((procedure) => setEditMap(oldValue => oldValue.set(procedure.id, false)))
      setEditMap(currentVisit.procedureRows.map(function (procedure) {
        return { id: procedure.id, canEdit: false }
      }
      )
      )
    }
  }, [currentVisit])

    const handleDeleteProcedure = (procedureId) => {
      let result = window.confirm('Ты реально хочешь удалить?');
      if(result){
          dispatch(deleteProcedure(procedureId, visitId));
      }
  }

   const handleEditProcedure = (procedureId) => {
      // editMap[procedureId] = true
      setEditMap([...editMap.filter((e) => e.id !== procedureId), {id: procedureId, canEdit: true}])
   }

   const checkCanEdit = (procedureId) => {
      return editMap.length > 0 && editMap.some((p) => p.id === procedureId) && editMap.filter((p) => p.id === procedureId)[0].canEdit
   }

   const submitProcedure = (values, procedureId) => { 
    dispatch(editProcedure({ ...values}, procedureId, visitId))
  }

  const handleCancel = (procedureId) => {
    setEditMap([...editMap.filter((e) => e.id !== procedureId), {id: procedureId, canEdit: false}])
  }


  return (
    currentVisit &&
    <div style={{ 'textAlign': 'center' }}>
      <h2>{currentVisit.finalTitle ? currentVisit.finalTitle : currentVisit.creationTitle}!</h2>

      {currentVisit.procedureRows.length > 0 && currentVisit.procedureRows.map(
        (procedure) =>
          <Paper style={{ marginBottom: '10px', minHeight: '50px', background: '#f5ebf4', paddingBottom: '20px' }} key={procedure.id}>
            <Grid container direction="column">
              <Grid item style={{ flex: 0.1, alignSelf: 'end' }}>
                <IconButton onClick={() => handleEditProcedure(procedure.id)}>
                  <EditIcon />
                </IconButton>
                <IconButton onClick={() => handleDeleteProcedure(procedure.id)}>
                  <ClearIcon />
                </IconButton>
              </Grid>
            </Grid>
            <Grid item style={{ flex: 0.9 }}>
              <ProcedureForm form={`procedureForm${procedure.id}`} procedure={procedure} onSubmit={(values) => submitProcedure(values, procedure.id)} canEdit={checkCanEdit(procedure.id)} visitId={visitId} cancel={() => handleCancel(procedure.id)}/>
            </Grid>
          </Paper>
      )}
      <AddProcedure visitId={visitId} />
    </div>
  );
}

export default withRouter(Visit);
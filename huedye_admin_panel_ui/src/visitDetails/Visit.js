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
import {getVisit} from '../reducers/index'
import AddVisit from '../clientDetails/AddVisit';
import { Link } from 'react-router-dom';
import ProcedureForm from './ProcedureForm';


const Visit = (match) => {
    const dispatch = useDispatch()
    let { visitId } = useParams()
    React.useEffect(() => {
        if(visitId){
            dispatch(getVisit(visitId))
        }
    }, [visitId])
    let currentVisit = useSelector(state => state.mainReducer.currentVisit)
    // let visits = currentClient && currentClient.visits
  return (
    currentVisit &&
    <div style={{ 'textAlign': 'center' }}>
      <h2>{currentVisit.finalTitle ? currentVisit.finalTitle : currentVisit.creationTitle}!</h2>
      {currentVisit.procedureRows && currentVisit.procedureRows.map(
        (procedure) =>
          <Paper style={{ marginBottom: '10px', minHeight: '50px', background: '#f5ebf4' }}>
              <ProcedureForm form={`procedureForm${procedure.id}`}  procedure={procedure}/>
          </Paper>
             )}
    </div>
  );
}

export default withRouter(Visit);

import './App.css';
import * as React from 'react';
import ClientsTable from './clientTable/ClientsTable';
import {
  Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import { Fragment } from 'react';
import Client from './clientDetails/Client';
import history from './history';
import Visit from './visitDetails/Visit';
import MaterialsTable from './MaterialsDetails/MaterialsTable';

function App() {
  return (
    <Router history={history}>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Домой</Link>
            </li>
            <li>
              <Link to="/clients">Клиенты</Link>
            </li>
            <li>
              <Link to="/materials">Материалы</Link>
            </li>
          </ul>
        </nav>

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
        <Route path="/visit/:visitId">
            <Visit/>
          </Route>
        <Route path="/client/:clientId">
            <Client/>
          </Route>
          <Route path="/clients">
            <ClientsTable/>
          </Route>
          <Route path="/materials">
            <MaterialsTable />
          </Route>
          <Route path="/">
            <Fragment />
          </Route>
        </Switch>
      </div>
    </Router>

  );
}

export default App;

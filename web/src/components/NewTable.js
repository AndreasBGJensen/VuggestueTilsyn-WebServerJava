import React from 'react'
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import IconButton from "@material-ui/core/IconButton";
import Collapse from "@material-ui/core/Collapse/Collapse";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableBody from "@material-ui/core/TableBody";
import TableContainer from "@material-ui/core/TableContainer";
import Paper from "@material-ui/core/Paper/Paper";
import {makeStyles} from "@material-ui/core/styles";
import PropTypes from 'prop-types';
import PostData from '../data/newData.json'



const useRowStyles = makeStyles({
    root: {
        '& > *': {
            borderBottom: 'unset',
        },
    },
});



const jsonObject = PostData;

function createData(name, venteliste, homepage, InklussionOgFællesskab,SocialeRelationer,Forældresamarbejde,SammenhængOgOvergange,KravOmReflektion) {
    return { name, venteliste, homepage, InklussionOgFællesskab,SocialeRelationer,Forældresamarbejde,SammenhængOgOvergange,KravOmReflektion};
}

function createDataArray(jsonObject){
    console.log(typeof jsonObject)

    const rowsh = [];
    for (var i = 0; i < jsonObject.length; i++) {
        var obj = jsonObject[i];

        console.log(obj);
        var data = createData(obj.name, obj.venteliste, obj.homepage,
            obj.periodiskTilsyn.foerste.InklussionOgFællesskab.indsats,
            obj.periodiskTilsyn.foerste.Forældresamarbejde.indsats,
            obj.periodiskTilsyn.foerste.KravOmReflektion.indsats,
            obj.periodiskTilsyn.foerste.SocialeRelationer.indsats,
            obj.periodiskTilsyn.foerste.Sprogindsatsen.indsats);
        var data2 = JSON.stringify(obj);
        rowsh.push(data);


    }
    console.log(rowsh);
    return rowsh;
}




const rows = createDataArray(jsonObject);

function Row(props) {
    const { row } = props;
    const [open, setOpen] = React.useState(false);
    const classes = useRowStyles();
    const [anbefaling, setAnbefaling] = React.useState([]);
    const [begrundelse, setBegrundelse] = React.useState([]);


    const onClickRandomButton = (anbefaling, begrundelse) => {

        if(!open){
            setAnbefaling(anbefaling);
            setBegrundelse(begrundelse);
            console.log(anbefaling);
            console.log(begrundelse);
        }
        setOpen(!open);

        console.log(open);

    };


    return (
        <React.Fragment>
            <TableRow >
                <TableCell component="th" scope="row">
                    <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
                        {<h1>{row.name}</h1>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
                    {<h1>{row.venteliste}</h1>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
                        { <h1>{row.homepage}</h1>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.InklussionOgFællesskab.anbefaling,row.periodiskTilsyn.foerste.InklussionOgFællesskab.begrundelse)}>
                        {<h1>{row.periodiskTilsyn.foerste.InklussionOgFællesskab.indsats}</h1>}
                        </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.SocialeRelationer.anbefaling,row.periodiskTilsyn.foerste.SocialeRelationer.begrundelse)}>
                        {<h1>{row.periodiskTilsyn.foerste.SocialeRelationer.indsats}</h1>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.Forældresamarbejde.anbefaling,row.periodiskTilsyn.foerste.Forældresamarbejde.begrundelse)}>
                        {<h1>{row.periodiskTilsyn.foerste.Forældresamarbejde.indsats}</h1>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.SammenhængOgOvergange.anbefaling,row.periodiskTilsyn.foerste.SammenhængOgOvergange.begrundelse)}>
                        { <h1>{row.periodiskTilsyn.foerste.SammenhængOgOvergange.indsats}</h1>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.KravOmReflektion.anbefaling,row.periodiskTilsyn.foerste.KravOmReflektion.begrundelse)}>
                        <h1>{row.periodiskTilsyn.foerste.KravOmReflektion.indsats}</h1>
                    </IconButton>
                </TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
                    <Collapse in={open} timeout="auto" unmountOnExit>
                        <Box margin={1}>
                            <Typography variant="h6" gutterBottom component="div">
                                History
                            </Typography>
                            <Table size="small" aria-label="purchases">
                                <TableHead>
                                    <TableRow>
                                        <TableCell>Date</TableCell>
                                        <TableCell>Customer</TableCell>
                                        <TableCell align="right">Amount</TableCell>
                                        <TableCell align="right">Total price ($)</TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>

                                        <TableRow>
                                            <TableCell component="th" scope="row">
                                                {anbefaling}
                                            </TableCell>
                                            <TableCell>
                                                {begrundelse}
                                            </TableCell>

                                        </TableRow>
                                </TableBody>
                            </Table>
                        </Box>
                    </Collapse>
                </TableCell>
            </TableRow>
        </React.Fragment>
    );
}

Row.propTypes = {
    row: PropTypes.shape({
        calories: PropTypes.number.isRequired,
        carbs: PropTypes.number.isRequired,
        fat: PropTypes.number.isRequired,
        history: PropTypes.arrayOf(
            PropTypes.shape({
                amount: PropTypes.number.isRequired,
                customerId: PropTypes.string.isRequired,
                date: PropTypes.string.isRequired,
            }),
        ).isRequired,
        name: PropTypes.string.isRequired,
        price: PropTypes.number.isRequired,
        protein: PropTypes.number.isRequired,
    }).isRequired,
};


export default function NewTable() {
    return (
        <TableContainer component={Paper}>
            <Table aria-label="collapsible table">
                <TableHead>
                    <TableRow>
                        <TableCell>Navn</TableCell>
                        <TableCell align="center">Venteliste</TableCell>
                        <TableCell align="center">Hjemmeside</TableCell>
                        <TableCell align="center">Inklussion Og Fællesskab</TableCell>
                        <TableCell align="center">Sociale Relationer</TableCell>
                        <TableCell align="center">Forældresamarbejde</TableCell>
                        <TableCell align="center">Sammenhæng Og Overgange</TableCell>
                        <TableCell align="center">Krav Om Reflektion</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {jsonObject.payload.map((row) => (
                        <Row key={row.name} row={row} />
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

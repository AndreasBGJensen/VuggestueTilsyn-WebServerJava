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







function Row(props) {
    const { row } = props;
    const [open, setOpen] = React.useState(false);
    const classes = useRowStyles();
    const [anbefaling, setAnbefaling] = React.useState([]);
    const [begrundelse, setBegrundelse] = React.useState([]);
    const [openFane, setopenFane] = React.useState([]);
    const [institutionToInspect, setinstitutionToInspect] = React.useState([]);



    const onClickRandomButton = (anbefaling, begrundelse, fane, institution) => {

        if(!open){
            setAnbefaling(anbefaling);
            setBegrundelse(begrundelse);
            setopenFane(fane);
            setinstitutionToInspect(institution);
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
                        {<p>{row.name}</p>}
                    </IconButton>
                </TableCell>
                <TableCell align="center">
                    <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
                    {<p>{row.venteliste}</p>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">

                       <a>{row.homepage}</a>

                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.InklussionOgFællesskab.anbefaling,row.periodiskTilsyn.foerste.InklussionOgFællesskab.begrundelse,"InklussionOgFællesskab",row.name)}>
                        {<p>{row.periodiskTilsyn.foerste.InklussionOgFællesskab.indsats}</p>}
                        </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.SocialeRelationer.anbefaling,row.periodiskTilsyn.foerste.SocialeRelationer.begrundelse,"SocialeRelationer",row.name)}>
                        {<p>{row.periodiskTilsyn.foerste.SocialeRelationer.indsats}</p>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.Forældresamarbejde.anbefaling,row.periodiskTilsyn.foerste.Forældresamarbejde.begrundelse,"Forældresamarbejde",row.name)}>
                        {<p>{row.periodiskTilsyn.foerste.Forældresamarbejde.indsats}</p>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.SammenhængOgOvergange.anbefaling,row.periodiskTilsyn.foerste.SammenhængOgOvergange.begrundelse,"SammenhængOgOvergange" ,row.name)}>
                        { <p>{row.periodiskTilsyn.foerste.SammenhængOgOvergange.indsats}</p>}
                    </IconButton>
                </TableCell>
                <TableCell align="right">
                    <IconButton aria-label="expand row" size="small" onClick={() => onClickRandomButton(row.periodiskTilsyn.foerste.KravOmReflektion.anbefaling,row.periodiskTilsyn.foerste.KravOmReflektion.begrundelse,"KravOmReflektion",row.name)}>
                        <p>{row.periodiskTilsyn.foerste.KravOmReflektion.indsats}</p>
                    </IconButton>
                </TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={12} align="center">
                    <Collapse in={open} timeout="auto" unmountOnExit>
                        <Box margin={1}>
                            <Typography variant="h6" gutterBottom component="div">
                                {institutionToInspect}
                            </Typography>
                            <Typography variant="h6" gutterBottom component="div">
                                {openFane}
                            </Typography>
                            <Table size="small" aria-label="purchases">
                                <TableHead>
                                    <TableRow>
                                        <TableCell>Anbefaling</TableCell>
                                        <TableCell>Begrundelse</TableCell>
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




export default function NewTable(props) {
    return (
        <TableContainer component={Paper}>
            <Table aria-label="collapsible table">
                <TableHead>
                    <TableRow>
                        <TableCell><h2>Navn</h2></TableCell>
                        <TableCell align="center"><h2>Venteliste</h2></TableCell>
                        <TableCell align="center"><h2>Hjemmeside</h2></TableCell>
                        <TableCell align="center"><h2>Inklussion Og Fællesskab</h2></TableCell>
                        <TableCell align="center"><h2>Sociale Relationer</h2></TableCell>
                        <TableCell align="center"><h2>Forældresamarbejde</h2></TableCell>
                        <TableCell align="center"><h2>Sammenhæng Og Overgange</h2></TableCell>
                        <TableCell align="center"><h2>Krav Om Reflektion</h2></TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {jsonObject.payload.filter(name =>{
                        return name.name.toLowerCase().indexOf(props.searchword.toLowerCase()) >=0;

                    }).map((row) => (
                        <Row key={row.name} row={row} />
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}
